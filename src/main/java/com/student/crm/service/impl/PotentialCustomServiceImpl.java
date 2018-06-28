package com.student.crm.service.impl;

import com.student.crm.domain.Charge;
import com.student.crm.domain.ContractManage;
import com.student.crm.domain.Employee;
import com.student.crm.domain.PotentialCustom;
import com.student.crm.mapper.ChargeMapper;
import com.student.crm.mapper.ContractManageMapper;
import com.student.crm.mapper.PotentialCustomMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;
import com.student.crm.service.IPotentialCustomService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PotentialCustomServiceImpl implements IPotentialCustomService {
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage simpleMailMessage;
	@Autowired
	private PotentialCustomMapper  potentialCustomMapper;

	@Autowired
    private ChargeMapper chargeMapper;
    @Autowired
    private ContractManageMapper contractManageMapper;

    public int deleteByPrimaryKey(Long id) {
		return potentialCustomMapper.deleteByPrimaryKey(id);
	}

	public int insert(PotentialCustom record) {
        record.setInputTime(new Date());
       record.setInputMan((Employee) SecurityUtils.getSubject().getPrincipal());
       record.setBuildFileTime(new Date());
       record.setStudentState(0L);



        int count = potentialCustomMapper.insert(record);
		return count;
	}

	public PotentialCustom selectByPrimaryKey(Long id) {
		return potentialCustomMapper.selectByPrimaryKey(id);
	}

	public List<PotentialCustom> selectAll() {
		return potentialCustomMapper.selectAll();
	}

	public int updateByPrimaryKey(PotentialCustom record) {
		return potentialCustomMapper.updateByPrimaryKey(record);
	}

    @Override
    public PageResult queryPage(QueryObject qo) {
        //符合条件的总数
        Long count = potentialCustomMapper.queryPageCount(qo);
        if(count <= 0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<PotentialCustom> result =  potentialCustomMapper.queryPageData(qo);
        return new PageResult(count, result);

    }

    @Override
    public void saveFormalStudent(PotentialCustom potentialCustom) {
	    // 改变当前的状态
        potentialCustom.setStudentState(1l);


        potentialCustomMapper.saveFormalStudent(potentialCustom);

        // 在收款 的项里面插入数据
        Charge charge = new Charge();
        charge.setChargeDate(new Date());
        String randomUUID = UUID.randomUUID().toString();
        charge.setBillNumber(randomUUID );
        charge.setChargeMoney(new BigDecimal(potentialCustom.getDefraiedTuition()));
        charge.setStudent(potentialCustom);
        Employee currentEmp = (Employee) SecurityUtils.getSubject().getPrincipal();
        charge.setPayee(currentEmp);
        charge.setMarketing(currentEmp);
        charge.setClassroom(potentialCustom.getCurrentClass());
        charge.setChargeType(potentialCustom.getPayWay());
        charge.setSubject(potentialCustom.getIntentionSubject());

        chargeMapper.insert(charge);


        // 还需要去在合同里面去修改
        ContractManage contractManage = new ContractManage();
        contractManage.setContractSn(randomUUID );
        contractManage.setClient(potentialCustom);
        contractManage.setSignTime(new Date());
        contractManage.setSaleMan(potentialCustom.getMarketingMan());
        contractManage.setTotalAmount(new BigDecimal(potentialCustom.getTotalTuition()));
        contractManage.setOrderAmount(new BigDecimal(potentialCustom.getTotalTuition()));
        contractManage.setRecentUpdateTime(new Date());
        contractManage.setState(0);
        contractManageMapper.insert(contractManage);

    }

    @Override
    public void changeStudentState(PotentialCustom potentialCustom) {

        potentialCustomMapper.changeCustomToPool(potentialCustom);
    }

    @Override
    public void updateLossStudent(PotentialCustom potentialCustom) {
        potentialCustomMapper.PotentialCustom(potentialCustom);
    }

    @Override
    public void updateInformById(Long id, String email) {
        if(StringUtils.isBlank(email)){
            throw new RuntimeException("邮箱为空");
        }
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("开学通知");
        simpleMailMessage.setText("开学了请尽快来上课");
        mailSender.send(simpleMailMessage);
        potentialCustomMapper.updateInformById(id);
    }


}

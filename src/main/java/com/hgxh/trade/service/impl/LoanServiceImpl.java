package com.hgxh.trade.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgxh.trade.dao.LoanInformationsDao;
import com.hgxh.trade.dao.LoanRepayInformationsDao;
import com.hgxh.trade.dao.LoanRepayPlanDao;
import com.hgxh.trade.entity.LoanInformationsEntity;
import com.hgxh.trade.entity.LoanRepayInformationsEntity;
import com.hgxh.trade.entity.LoanRepayPlanEntity;
import com.hgxh.trade.enums.BaseExceptionMsg;
import com.hgxh.trade.enums.LoanStatusEnum;
import com.hgxh.trade.enums.RepayPlanEnum;
import com.hgxh.trade.enums.RepayTypeEnum;
import com.hgxh.trade.enums.RepayWayEnum;
import com.hgxh.trade.enums.WhetherEnum;
import com.hgxh.trade.param.AddLoanParam;
import com.hgxh.trade.param.LoanRepayParam;
import com.hgxh.trade.result.ResultInfo;
import com.hgxh.trade.service.LoanService;
import com.hgxh.trade.util.DateUtil;

/**
*@ClassName: LoanServiceImpl
*@Description: 
*@author YY 
*@date 2016年12月13日  下午3:29:09
*@version 1.0
*/
@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanInformationsDao loanInformationsDao;
	@Autowired
	private LoanRepayPlanDao loanRepayPlanDao;
	@Autowired
	private LoanRepayInformationsDao loanRepayInformationsDao;

	/**
	 * 添加借款信息
	 * @param param
	 * @return
	 */
	@Override
	public ResultInfo addLoanNotice(AddLoanParam param) {
		//插入借款详情
		LoanInformationsEntity entity = copyInfoProperties(param);
		loanInformationsDao.insertSelective(entity);
		//插入还款计划
		insertLoanRepayPlan(param);
		return new ResultInfo(BaseExceptionMsg.SUCCESS);
	}

	/**
	 * 借款详情复制参数
	 * @param param
	 * @return
	 */
	private LoanInformationsEntity copyInfoProperties(AddLoanParam param){
		LoanInformationsEntity entity = new LoanInformationsEntity();
		BeanUtils.copyProperties(param, entity);
		entity.setRepayType(RepayTypeEnum.valueOf(param.getRepayType()));
		entity.setRepayWay(RepayWayEnum.valueOf(param.getRepayWay()));
		entity.setAmount(new BigDecimal(param.getAmount()));
		entity.setYeild(new BigDecimal(param.getYeild()));
		entity.setBeginTime(Long.parseLong(param.getBeginTime()));
		entity.setEndTime(Long.parseLong(param.getEndTime()));
		entity.setStatus(LoanStatusEnum.PROCESSING);
		entity.setCreateTime(DateUtil.getLastModifyTime());
		entity.setLastModifyTime(DateUtil.getLastModifyTime());
		return entity;
	}
	
	/**
	 * 还款计划复制参数
	 * @param param
	 * @return
	 */
	private void insertLoanRepayPlan(AddLoanParam param){
		LoanRepayPlanEntity entity = new LoanRepayPlanEntity();
		entity.setIssueVoucherNo(param.getIssueVoucherNo());
		entity.setStatus(RepayPlanEnum.NO);
		entity.setCurrent(WhetherEnum.NO);
		entity.setCreateTime(DateUtil.getLastModifyTime());
		entity.setLastModifyTime(DateUtil.getLastModifyTime());
		int months = DateUtil.getMonths(Long.parseLong(param.getEndTime()), Long.parseLong(param.getBeginTime()));
		String beginTime = DateUtil.format1DateToString(Long.parseLong(param.getBeginTime()));
		String []b = beginTime.split("-");
		int year = Integer.parseInt(b[0]);
		int month = Integer.parseInt(b[1]);
		int day = Integer.parseInt(b[2]);
		String endTime = DateUtil.format1DateToString(Long.parseLong(param.getBeginTime()));
		String []e = endTime.split("-");
		int endYear = Integer.parseInt(e[0]);
		int endMonth = Integer.parseInt(e[1]);
		int endDay = Integer.parseInt(e[2]);
		BigDecimal repayCapital = new BigDecimal(0);
		BigDecimal yeild = new BigDecimal(param.getYeild()).divide(new BigDecimal(100));
		if(param.getRepayWay() != RepayWayEnum.DISPOSABLE.toString()){
			for(int i=0;i<months;i++){
				month++;
				if(month>12){
					year++;
					month = month-12;
				}
				String mon = month+"";
				if(mon.length()==1){
					mon="0"+mon;
				}
				long repayTime = DateUtil.stringToTimestamp(""+year+mon+day);
				entity.setRepayTime(repayTime);
				//等额本金
				if(RepayWayEnum.AVERAGECAPITAL.toString().equals(param.getRepayWay())){
					//每月本金=本金/月数
					BigDecimal capita = new BigDecimal(param.getAmount()).divide(new BigDecimal(months),2,BigDecimal.ROUND_HALF_UP);
					entity.setCapital(capita);
					//每月利息=剩余本金（本金-已还本金）*利率/12
					BigDecimal interest = (new BigDecimal(param.getAmount()).subtract(capita.multiply(new BigDecimal(i)))).
							multiply(yeild).divide(new BigDecimal(12),2,BigDecimal.ROUND_HALF_UP);
					entity.setCapital(capita);
					entity.setInterest(interest);
				}
				//等额本息
				if(RepayWayEnum.AVERAGEINTEREST.toString().equals(param.getRepayWay())){
					//总额=本金*利率*（1+利率）^月数/（（1+利率）^月数-1）
					BigDecimal pow = (new BigDecimal(1).add(yeild)).pow(months);
					BigDecimal amount = new BigDecimal(param.getAmount()).multiply(yeild).multiply(pow).divide(pow.subtract(new BigDecimal(1)),2,BigDecimal.ROUND_HALF_UP);
					//每月利息=剩余本金（本金-已还本金）*利率/12
					BigDecimal interest = (new BigDecimal(param.getAmount()).subtract(repayCapital)).multiply(yeild)
							.divide(new BigDecimal(12),2,BigDecimal.ROUND_HALF_UP);
					BigDecimal capital = amount.subtract(interest);
					entity.setCapital(capital);
					entity.setInterest(interest);
					repayCapital = repayCapital.add(capital);
				}
				loanRepayPlanDao.insertSelective(entity);		
			}
		}else{
			//一次性还本
			if(day == 20){
				for(int i=0;i<months;i++){
					month++;
					if(month>12){
						year++;
						month = month-12;
					}
					String mon = month+"";
					if(mon.length()==1){
						mon="0"+mon;
					}
					long repayTime = DateUtil.stringToTimestamp(""+year+mon+day);
					entity.setRepayTime(repayTime);
					//每月利息=本金*年利率/12
					entity.setInterest(new BigDecimal(param.getAmount()).multiply(yeild)
							.divide(new BigDecimal(12),2,BigDecimal.ROUND_HALF_UP));
					if(i != months-1){
						entity.setCapital(new BigDecimal(0));
					}else{
						entity.setCapital(new BigDecimal(param.getAmount()));
					}
					loanRepayPlanDao.insertSelective(entity);
				}
			}else if(day < 20){
				//第一期
				entity.setRepayTime(DateUtil.stringToTimestamp(""+year+month+"20"));
				//利息=本金*年利率/360*天数
				entity.setInterest(new BigDecimal(param.getAmount()).multiply(yeild)
				.divide(new BigDecimal(360),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(20-day)));
				entity.setCapital(new BigDecimal(0));
				loanRepayPlanDao.insertSelective(entity);
				//中间期
				for(int i=0;i<months-1;i++){
					month++;
					if(month>12){
						year++;
						month = month-12;
					}
					String mon = month+"";
					if(mon.length()==1){
						mon="0"+mon;
					}
					long repayTime = DateUtil.stringToTimestamp(""+year+mon+"20");
					entity.setRepayTime(repayTime);
					//每月利息=本金*年利率/12
					entity.setInterest(new BigDecimal(param.getAmount()).multiply(yeild)
							.divide(new BigDecimal(12),2,BigDecimal.ROUND_HALF_UP));
					entity.setCapital(new BigDecimal(0));
					loanRepayPlanDao.insertSelective(entity);
				}
				//最后一期
				entity.setRepayTime(Long.parseLong(param.getEndTime()));
				int sdays = DateUtil.getMonthDays(endYear,endMonth);
				//利息=本金*年利率/360*天数
				entity.setInterest(new BigDecimal(param.getAmount()).multiply(yeild)
						.divide(new BigDecimal(360),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(sdays-20+endDay)));
				entity.setCapital(new BigDecimal(param.getAmount()));
				loanRepayPlanDao.insertSelective(entity);
			}else{
				//第一期
				if(month == 12){
					year = year +1;
					month = 1;
				}else{
					month = month+1;
				}
				String mon = month+"";
				if(mon.length()==1){
					mon="0"+mon;
				}
				entity.setRepayTime(DateUtil.stringToTimestamp(""+year+mon+"20"));
				//利息=本金*年利率/360*天数
				entity.setInterest(new BigDecimal(param.getAmount()).multiply(yeild)
				.divide(new BigDecimal(360),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(DateUtil.getMonthDays(year, month)-day+20)));
				entity.setCapital(new BigDecimal(0));
				loanRepayPlanDao.insertSelective(entity);
				//中间期
				for(int i=0;i<months-1;i++){
					month++;
					if(month>12){
						year++;
						month = month-12;
					}
					String mon1 = month+"";
					if(mon1.length()==1){
						mon1="0"+mon1;
					}
					long repayTime = DateUtil.stringToTimestamp(""+year+mon1+"20");
					entity.setRepayTime(repayTime);
					//每月利息=本金*年利率/12
					entity.setInterest(new BigDecimal(param.getAmount()).multiply(yeild)
							.divide(new BigDecimal(12),2,BigDecimal.ROUND_HALF_UP));
					entity.setCapital(new BigDecimal(0));
					loanRepayPlanDao.insertSelective(entity);
				}
				//最后一期
				entity.setRepayTime(Long.parseLong(param.getEndTime()));
				entity.setInterest(new BigDecimal(param.getAmount()).multiply(yeild)
						.divide(new BigDecimal(360),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(day-20)));
				entity.setCapital(new BigDecimal(param.getAmount()));
				loanRepayPlanDao.insertSelective(entity);
			}
		}
		loanRepayPlanDao.updateCurrentByVoucherNo(entity.getIssueVoucherNo());
	}
	
	/**
	 * 还款通知
	 * @param param
	 * @return
	 */
	@Override
	public ResultInfo loanReplyNotice(LoanRepayParam param) {
		LoanRepayInformationsEntity entity = new LoanRepayInformationsEntity();
		entity.setIssueVoucherNo(param.getIssueVoucherNo());
		entity.setOverdue(WhetherEnum.valueOf(param.getOverdue()));
		entity.setOverdueDays(Integer.parseInt(param.getOverdueDays()));
		entity.setDefaultAmount(new BigDecimal(param.getDefaultAmount()));
		entity.setAheadRepay(WhetherEnum.valueOf(param.getAheadRepay()));
		entity.setUserRepayTime(Long.parseLong(param.getUserRepayTime()));
		entity.setCreateTime(DateUtil.getLastModifyTime());
		loanRepayInformationsDao.insertSelective(entity);
		if(WhetherEnum.YES.equals(entity.getAheadRepay())){
			loanInformationsDao.updateStatusByVoucherNo(entity.getIssueVoucherNo());
			loanRepayPlanDao.updateStatusByVoucherNo(entity.getIssueVoucherNo());
			loanRepayPlanDao.updateCurrentNoByVoucherNo(entity.getIssueVoucherNo());
		}else{
			loanRepayPlanDao.updateStatusByConditions(entity.getIssueVoucherNo(), entity.getUserRepayTime());
			loanRepayPlanDao.updateCurrentNoByVoucherNo(entity.getIssueVoucherNo());
			loanRepayPlanDao.updateCurrentByVoucherNo(entity.getIssueVoucherNo());
		}
		return new ResultInfo(BaseExceptionMsg.SUCCESS);
	}

}

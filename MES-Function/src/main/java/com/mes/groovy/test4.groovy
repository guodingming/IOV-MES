package com.mes.groovy

/**
 * Created by dengyun.le on 2017/8/21.
 */
import com.mes.common.utils.PrintCodeUtil

def clientFixcon = PrintCodeUtil.strCut("$FixConfiger",12)
/*def yeartemp = PrintCodeUtil.tyear("$BatchNo")
def year = Integer.toHexString(yeartemp).toUpperCase();
def monthtemp =PrintCodeUtil.tmonth("$BatchNo")
def daytemp = PrintCodeUtil.tday("$BatchNo")*/

 clientFixcon+"$BatchNo$SerialNo"
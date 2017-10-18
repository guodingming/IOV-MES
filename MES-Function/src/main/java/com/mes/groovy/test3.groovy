package com.mes.groovy

/**
 * Created by dengyun.le on 2017/8/18.
 */
import com.mes.common.utils.PrintCodeUtil

def part_number=PrintCodeUtil.strCut("$CuPartNumber",4)

    part_number+"$BatchNo$SerialNo"
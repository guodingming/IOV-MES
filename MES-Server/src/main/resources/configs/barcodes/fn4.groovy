package configs.barcodes

/**
 * 左截取5位，不足右补F。例如1234，转为1234F；123456，转为12345
 * Created by xiuyou.xu on 2017/10/10.
 */
return (value + "FFFFF").substring(0, 5)
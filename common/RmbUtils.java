import java.math.BigDecimal;
import java.util.*;

public class RmbUtils {

    public static void main(String[] args) {

//      vm.put("零",BigDecimal.valueOf(0));
//      vm.put("整",BigDecimal.valueOf(0));
        BigDecimal r = null;
//      r = parse("贰拾肆");
        try {
            r = big2Num("壹万零壹圆");
//            System.out.println(r.toString());

            String num = "1.00";
            String big = num2Big(num);
            System.out.println(big);

            num = "1.10000000";
            big = num2Big(num);
            System.out.println(big);

            num = "1.1100000000";
            big = num2Big(num);
            System.out.println(big);

            num = "1.010000000";
            big = num2Big(num);
            System.out.println(big);


//            String small = big2Num(big).toString();
//            if(!small.equals(num))
///*                System.out.println(big + " " + small + " " + num);*/

        } catch (Exception e){
            e.printStackTrace();
        }
//      r = parse("陆万", value);

    }

    public static BigDecimal big2Num(String bignum) throws Exception{

        BigDecimal value = BigDecimal.valueOf(0);
        BigDecimal r = null;
        if(bignum.matches("^[拾佰仟万亿].*")){
            bignum = "壹" + bignum;
        }

        if(!bignum.matches("^[壹贰叁肆伍陆柒捌玖零].+") || !bignum.matches(".+[元圆整角分]$")){
            return BigDecimal.valueOf(-1);
        }


        bignum = bignum.replaceAll("[元圆整]", "");
        try {
            r = big2NumParser(bignum, value, 0);
        } catch(Exception e){
            if("count".equals(e.getMessage())){
                return BigDecimal.valueOf(-1);
            }
            throw e;
        }
        return r;
    }

    public static BigDecimal big2NumParser(String bignum, BigDecimal value, int count) throws Exception{
        count++;

        if (count>100){
            throw new Exception("count");
        }

        Map<String, BigDecimal> vm = new HashMap<String, BigDecimal>();
        vm.put("壹",BigDecimal.valueOf(1));
        vm.put("贰",BigDecimal.valueOf(2));
        vm.put("叁",BigDecimal.valueOf(3));
        vm.put("肆",BigDecimal.valueOf(4));
        vm.put("伍",BigDecimal.valueOf(5));
        vm.put("陆",BigDecimal.valueOf(6));
        vm.put("柒",BigDecimal.valueOf(7));
        vm.put("捌",BigDecimal.valueOf(8));
        vm.put("玖",BigDecimal.valueOf(9));
        vm.put("零",BigDecimal.valueOf(0));

        try {
            if(bignum.length()>0){

                if(bignum.matches(".*分$")) {
                    String t = bignum.replaceAll(".*([零壹贰叁肆伍陆柒捌玖])分$", "$1");
                    value = value.add(vm.get(t).multiply(BigDecimal.valueOf(0.01)));
                    bignum = bignum.substring(0, bignum.length() - 2);
                }

                if(bignum.matches(".*角$")) {
                    String t = bignum.replaceAll(".*([零壹贰叁肆伍陆柒捌玖])角$", "$1");
                    value = value.add(vm.get(t).multiply(BigDecimal.valueOf(0.1)));
                    bignum = bignum.substring(0, bignum.length() - 2);
                }

                if(bignum.matches(".*[壹贰叁肆伍陆柒捌玖]$")) {
                    String t = bignum.replaceAll(".*([零壹贰叁肆伍陆柒捌玖])$", "$1");
                    value = value.add(vm.get(t));
                    bignum = bignum.substring(0, bignum.length() - 1);
                }

                if(bignum.matches(".*零$")){
                    bignum = bignum.substring(0, bignum.length() - 1);
                }

                if(bignum.matches(".*拾$")) {
                    String t = bignum.replaceAll(".*([壹贰叁肆伍陆柒捌玖])拾$", "$1");
                    value = value.add(vm.get(t).multiply(BigDecimal.valueOf(10)));
                    bignum = bignum.substring(0, bignum.length() - 2);
                }

                if(bignum.matches(".*零$")){
                    bignum = bignum.substring(0, bignum.length() - 1);
                }

                if(bignum.matches(".*佰$")) {
                    String t = bignum.replaceAll(".*([壹贰叁肆伍陆柒捌玖])佰$", "$1");
                    value = value.add(vm.get(t).multiply(BigDecimal.valueOf(100)));
                    bignum = bignum.substring(0, bignum.length() - 2);
                }

                if(bignum.matches(".*零$")){
                    bignum = bignum.substring(0, bignum.length() - 1);
                }

                if(bignum.matches(".*仟$")) {
                    String t = bignum.replaceAll(".*([壹贰叁肆伍陆柒捌玖])仟$", "$1");
                    value = value.add(vm.get(t).multiply(BigDecimal.valueOf(1000)));
                    bignum = bignum.substring(0, bignum.length() - 2);
                }

                if(bignum.matches(".*零$")){
                    bignum = bignum.substring(0, bignum.length() - 1);
                }

                if(bignum.matches(".*万$")) {
                    String t = bignum.replaceAll(".*?([零拾佰仟壹贰叁肆伍陆柒捌玖]+)万$", "$1");
                    value = value.add(big2NumParser(t, BigDecimal.valueOf(0), count).multiply(BigDecimal.valueOf(10000)));
                    bignum = bignum.substring(0, bignum.length() - t.length() - 1);
                }

                if(bignum.matches(".*零$")){
                    bignum = bignum.substring(0, bignum.length() - 1);
                }

                if(bignum.matches(".*亿$")) {
                    String t = bignum.replaceAll(".*?([零拾佰仟万壹贰叁肆伍陆柒捌玖]+)亿$", "$1");
                    value = value.add(big2NumParser(t, BigDecimal.valueOf(0), count).multiply(BigDecimal.valueOf(100000000)));
                    bignum = bignum.substring(0, bignum.length() - t.length() - 1);
                }
            }
        } catch(Exception e){
            throw e;
        }
        return value;
    }


    static String num2Big(String strNum){
        strNum = strNum.replaceAll("^0+", "");

        strNum = strNum.replaceAll("(\\.\\d{2})\\d+$", "$1");
        strNum = strNum.replaceAll("\\.0+$", "");
        strNum = strNum.replaceAll("(\\.\\d)0+$", "$1");


        String [] num = new String[] {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String [] unit = new String[] {"", "拾", "佰", "仟"};

        String bigStr = "";

        String[] numArr = strNum.split("\\.");

        String detailStr = "";
        if(numArr.length==2){
            String[] detail = numArr[1].split("");
            if (detail.length>1) detailStr = num[Integer.parseInt(String.valueOf(detail[1]))] + "分" + detailStr;
            if (detail.length>0) detailStr = num[Integer.parseInt(String.valueOf(detail[0]))] + "角" + detailStr;
        }

        detailStr = detailStr.replaceAll("零角", "零");

        String intNum = numArr[0];      //整数部份

        List<String> lstNum = new ArrayList<>();

        if(intNum.length()<=4){
            lstNum.add(intNum);
        } else {
            String a = "";
            String b = intNum;
            while(b.length()>4){
                intNum = b;
                a = intNum.replaceAll(".*(\\d{4})$", "$1");
                b = intNum.replaceAll("(.*)\\d{4}$", "$1");
                lstNum.add(a);
            }
            if(b.length()>0) lstNum.add(b);
        }

        List unitList = getUnit(lstNum.size());

        for(int i=0;i<lstNum.size();i++){
            char[] cArr = lstNum.get(i).toCharArray();
            cArr = reverse(cArr);

            String tmp = "";
            for(int j=0; j<cArr.length; j++){
                if(cArr[j]=='0') {
                    tmp = "零" + tmp;
                } else {
                    tmp = num[Integer.parseInt(String.valueOf(cArr[j]))] + unit[j] + tmp;
                }
            }
            tmp = tmp.replaceAll("零+", "零");
            tmp = tmp.replaceAll("零$", "");
            if(tmp.length()>0) tmp = tmp + unitList.get(i);
            bigStr = tmp + bigStr;
        }
        if(detailStr.length()==0){
            bigStr = bigStr + "圆整";
        } else {
            bigStr = bigStr + "圆" + detailStr;
        }

        return bigStr;
    }

    static List<String> getUnit(int i){
        List<String> l = new ArrayList<>();

        l.add("");
        if(i==0) return l;
        l.add("万");
        if(i==1) return l;

        if (i>1){
            for(int j=0; j<=i-2; j++) {
                if (l.get(l.size() - 1).startsWith("万")) {
                    l.add(l.get(l.size() - 1).replace("万", "亿"));
                } else if (l.get(l.size() - 1).startsWith("亿")) {
                    l.add("万" + l.get(l.size() - 1));
                }
            }
        }
        return l;
    }

    static char[] reverse(char[] str){
        for(int i=0;i<(int)str.length/2;i++){
            char temp = 0;
            temp = str[i];
            str[i] = str[str.length-1-i];
            str[str.length-1-i] = temp;
        }
        return str;
    }


}



public class Encoding {
    public static void main(String[] args) throws Exception {

        String str = "기분 좋은 날씨인데, 집에만 틀어박혀있어야 한다니.. 뷁";

        String[] encList = {"euc-kr", "ksc5601", "ms949", "unicode", "utf-8", "utf-16"};
/*
        byte defaultBytes[] = str.getBytes();
        byte eucBytes[] = str.getBytes("euc-kr");
        byte ksc5601Bytes[] = str.getBytes("ksc5601");
        byte ms949Bytes[] = str.getBytes("ms949");
        byte unicodeBytes[] = str.getBytes("unicode");
        byte utf8Bytes[] = str.getBytes("utf-8");
        byte utf16Bytes[] = str.getBytes("utf-16");
*/
        String enc = new java.io.OutputStreamWriter(System.out).getEncoding();
/*
        System.out.println("Current Encode : " + enc);
        System.out.println("기본 인코딩 : "+ new String(defaultBytes));
        System.out.println("EUC-KR 인코딩 : "+ new String(eucBytes,"euc-kr"));
        System.out.println("KSC5601 인코딩 : "+ new String(ksc5601Bytes,"ksc5601"));
        System.out.println("MS949 인코딩 : "+ new String(ms949Bytes,"ms949"));
        System.out.println("Unicode 인코딩 : "+ new String(unicodeBytes,"unicode"));
        System.out.println("UTF-8 인코딩 : "+ new String(utf8Bytes,"utf-8"));
        System.out.println("UTF-16 인코딩 : "+ new String(utf16Bytes,"utf-16"));
*/
        for(String encoding : encList){
            System.out.println("Encoding : " + encoding);
            for(String printing : encList){
                System.out.print("From : "+encoding+ " To : " + printing + " / ");
                System.out.println(new String (str.getBytes(encoding), printing));
            }
            System.out.println("");
        }
    }
}

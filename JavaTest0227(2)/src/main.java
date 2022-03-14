import java.lang.Exception;
import java.nio.charset.StandardCharsets;

class test0227{
    public static void main(java.lang.String[] args) {
        System.out.println("From BJ2557");
        BJ2557.main(null);

        System.out.println("From BJ10718");
        try {
            BJ10718.main3(null);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

// Hello World! 를 출력하시오
class BJ2557{
    public static void main(String[] args){
        System.out.println("Hello World!\n");
    }
}

// 두 줄에 걸쳐 "강한친구 대한육군"을 한 줄에 한 번씩 출력한다.
class BJ10718{
    public static void main(String[] args) throws Exception {
        String str = "강한친구 대한육군";
        byte[] bytes = str.getBytes();
        System.out.println("bytes length : "+bytes.length);
        int i = 0;
        for(byte b : bytes)
            System.out.println(i++);

        String encodedStr =  new String(bytes,showEncoding());
        //String encodedStr = Base64.getEncoder().encodeToString(bytes);
        System.out.println("encoding style : "+showEncoding());
        System.out.println("encodedStr length : "+encodedStr.length());
        System.out.println(encodedStr);
        System.out.println(encodedStr+"\n");
    }

    public static void main2(String[] args) throws Exception {
        String str = "강한친구 대한육군";
        String returnValue = "";

        String[] strArray = str.split(" ");
        for(int i = 0; i < strArray.length; i++)
        {
            System.out.println(i);
            byte[] byteBuffer = strArray[i].getBytes();
            returnValue += new String(byteBuffer, showEncoding()) + " ";
        }
        System.out.println(returnValue);
        //System.out.println(new String(str.getBytes(showEncoding()), showEncoding()));
    }

    public static void main3(String[] args) throws Exception {
        String str = "강한친구 대한육군";
        String str2 = "대한육군";
        String str3 = "무궁화 꽃이 피었습니다.";
        String str4 = "강한친구_대한육군";
        String str5 = "무궁화_꽃이_피었습니다.";
        System.out.println("UTF_8 to MS949: "+ new String(str.getBytes(StandardCharsets.UTF_8), showEncoding()));
        System.out.println("UTF_8 to UTF_8: "+ new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        System.out.println("UTF_8 to UTF_16: "+ new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_16));
        System.out.println("UTF_8 to UTF_16LE: "+ new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_16LE));
        System.out.println("UTF_8 to UTF_16BE: "+ new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_16BE));
        System.out.println("UTF_8 to UTF_8: "+ new String(str.getBytes(StandardCharsets.UTF_8), "utf-8"));
        System.out.println("UTF_8 to X_Windows_949: "+ new String(str.getBytes(StandardCharsets.UTF_8), "x-windows-949"));
        System.out.println("UTF_16BE to MS949: "+ new String(str.getBytes(StandardCharsets.UTF_16BE), showEncoding()));
        System.out.println("UTF_16LE to MS949: "+ new String(str.getBytes(StandardCharsets.UTF_16LE), showEncoding()));
        System.out.println("UTF_16 to MS949: "+ new String(str.getBytes(StandardCharsets.UTF_16), showEncoding()));
        System.out.println("ISO_8859_1 to MS949: "+ new String(str.getBytes(StandardCharsets.ISO_8859_1), showEncoding()));
        System.out.println("US_ASCII to MS949: "+ new String(str.getBytes(StandardCharsets.US_ASCII), showEncoding()));

        System.out.println("UTF_8 to MS949: "+ new String(str2.getBytes(StandardCharsets.UTF_8), showEncoding()));
        System.out.println("UTF_8 to MS949: "+ new String(str3.getBytes(StandardCharsets.UTF_8), showEncoding()));
        System.out.println("UTF_8 to MS949: "+ new String(str4.getBytes(StandardCharsets.UTF_8), showEncoding()));
        System.out.println("UTF_8 to MS949: "+ new String(str5.getBytes(StandardCharsets.UTF_8), showEncoding()));

    }

    private static String showEncoding(){
        String enc = new java.io.OutputStreamWriter(System.out).getEncoding();
        return enc;
    }
}
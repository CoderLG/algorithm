package cn.lg.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("jna")
@Slf4j
public class HelloWorld {
    public interface CLibrary extends Library {
        CLibrary INSTTANCE = (CLibrary) Native.loadLibrary("Dll3" , CLibrary.class);

        int Add(int a,int b);
        int Sub(int a,int b);
    }

    @GetMapping("seyHello")
     public void  seyHello(){
         int sum = CLibrary.INSTTANCE.Add(3, 6);
         int sub = CLibrary.INSTTANCE.Sub(3, 2);
         log.info("sum = " + sum);
         log.info("sub = " + sub);
     }


    public static void main(String[] args) {
        int sum = CLibrary.INSTTANCE.Add(3, 6);
        int sub = CLibrary.INSTTANCE.Sub(3, 2);
        log.info("sum = " + sum);
        log.info("sub = " + sub);
    }

}

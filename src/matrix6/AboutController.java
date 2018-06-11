package matrix6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AboutController implements Initializable {

    @FXML
    private Label lab3;
    @FXML
    private Label lab4;
    @FXML
    private Button C4I;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }

public void codeForIraq(){
    lab4.setText("Code For Iraq");
    lab3.setText("مبادرة إنسانية غير ربحية تهدف\n الى خدمة المجتمع عن طريق البرمجة.\n"
            + "تعتبر Code For Iraq مبادرة تعليمية حقيقية\n"
            + "ترعى المهتمين بتعلم تصميم \n"
            + "وبرمجة تطبيقات الهواتف \n"
            + ",مواقع الانترنيت وبرامج الحاسوب \n"
            + "والشبكات والاتصالات ونظم تشغيل الحاسوب\n"
            + "باستخدام تقنيات مفتوحة المصدر,\n"
            + "كما توفر لهم جميع الدروس التعليمية \n"
            + "اللازمة وبشكل مجاني تماما\n");
}  

public void OurTeame(){
    
    lab4.setText("فريق العمل ");
    lab3.setText(" محمد عيسى \n\n\n"
            + "علي حازم \n\n\n"
            + "حسين علوش\n\n\n"
            + "محمد جواد\n\n\n");
    
}

public void bpoutApplication(){
    lab4.setText("حول التطبيق");
    lab3.setText("التطبيق يقوم بتنظيم دخول \n"
            + "المراجعين الى صالة المراجعة\n"
            + "يتيح التعديل والبحث وتحديد\n"
            + "يمتاز بالامان حيث يكون الدخول \n"
            + "للتطبيق من خلال يوزر وباسسورد");
}

public void contactUs(){
    lab4.setText("اتصل بنا");
    lab3.setText("في حالة حدوث اي مشكلة في التطبيق الرجاء  \n"
            + "الاتصال بنا من خلال\n\n\n"
            + "phone : 07705528322 \n\n"
            + "Email : alihazim@codeforiraq.com");
}
    
}
/*
*/
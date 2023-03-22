package ApiToDB.ApiToDB;

import org.aspectj.apache.bcel.Repository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Repository infoRepositiory;

    @GetMapping("/api")
    public String index() {
        return "index";
    }

    @PostMapping("/api")
    public String load_save(@RequestParam("date") String date, Model model) {
        String result = "";
        try {
            String requestDate = date;
            URL url = new URL("https://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?serviceKey=mRmkUgxI6V2dJrv%2BYEdvvULX49q%2Fdme1Px7TMAV1hXuWyAXYjtr37jwZB1HFu%2FV0fFgRQB92IAe2RxwRDK3Akw%3D%3D&pageNo=1&startPage=1&numOfRows=100" + requestDate);
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject body = (JSONObject) jsonObject.get("body");
            Long totalCount = (Long) body.get("totalCount");

            JSONArray infoArr = (JSONArray) body.get("items");

            for (int i = 0; i < infoArr.size(); i++) {
                JSONObject tmp = (JSONObject) infoArr.get(i);
                medicineInfo infoObj = new medicineInfo(i + (long) 1, (String) tmp.get("entpName"), (String) tmp.get("itemName"), (String) tmp.get("efcyQesitm"), (String) tmp.get("useMethodQesitm"), (String) tmp.get("atpnWarnQesitm"), (String) tmp.get("atpnQesitm"), (String) tmp.get("itrcQesitm"), (String) tmp.get("seQesitm"), (String) tmp.get("depositMethodQesitm"), (String) tmp.get("itemImage"), (double) tmp.get("itemSeq"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
            return "redirect:/findname";
    }
}

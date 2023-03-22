package ApiToDB.ApiToDB;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class medicineInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entpName;
    private medicineInfo() {}
    private String itemName;
    private String efcyQesitm;
    private String useMethodQesitm;
    private String atpnWarnQesitm;
    private String atpnQesitm;
    private String itrcQesitm;
    private String seQesitm;
    private String depositMethodQesitm;
    private String itemImage;
    private double itemSeq;

    public medicineInfo(Long id, String itemName, String efcyQesitm, String entpName,String useMethodQesitm,String atpnWarnQesitm, String atpnQesitm, String itrcQesitm, String seQesitm, String depositMethodQesitm, String itemImage, double itemSeq) {
        this.id = id;
        this.entpName = entpName;
        this.itemName = itemName;
        this.itemSeq = itemSeq;
        this.efcyQesitm = efcyQesitm;
        this.useMethodQesitm = useMethodQesitm;
        this.atpnWarnQesitm = atpnWarnQesitm;
        this.atpnQesitm = atpnQesitm;
        this.itrcQesitm = itrcQesitm;
        this.seQesitm = seQesitm;
        this.depositMethodQesitm = depositMethodQesitm;
        this.itemImage = itemImage;
    }

}

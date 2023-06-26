package pl.pjatk.jazs24298nbp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/nbp")
public class NBPController {

    private final NBPService nbpService;

    public NBPController(NBPService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("{start}/{end}")
    public ResponseEntity<String> getGoldInDate(@PathVariable String start, @PathVariable String end) {
        ArrayList<GoldInfo> rates = nbpService.getGoldInDateGold(start, end);
        double sum = 0;
        for(GoldInfo rate : rates) sum+=rate.getCena();
        return ResponseEntity.ok(nbpService.getGoldInDate(start, end) + "\n\n AVG:" + (sum/rates.size()));
    }

    @GetMapping("{start}/{end}/test")
    public ResponseEntity<ArrayList<GoldInfo>> getCurrencyRates(@PathVariable String start, @PathVariable String end) {
        ArrayList<GoldInfo> rates = nbpService.getGoldInDateGold(start, end);
        return ResponseEntity.ok(rates);
    }



}

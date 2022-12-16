package kh.deli.domain.member.store.controller;

import kh.deli.domain.member.store.service.StoreSearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@AllArgsConstructor
@RequestMapping("storeSearch")
public class StoreSearchController {

    private final HttpSession session;
    private final StoreSearchService storeSearchService;

    @RequestMapping("")
    public String selectDistanceByAccSeq(Model model) throws Exception {
        int acc_seq = (Integer) session.getAttribute("acc_seq");
        List<Map<String, Object>> storeList = storeSearchService.selectDistanceByAccSeq(acc_seq);
//        for (int i = 0; i < storeList.size() ; i ++){
//            if( storeList.get(i).get("STORE_ORIGIN") instanceof java.sql.NClob ) {
//                StringBuffer strOut = new StringBuffer();
//                String str = "";
//                NClob nClob = (java.sql.NClob)storeList.get(i).get("STORE_ORIGIN");
//                BufferedReader br = new BufferedReader(nClob.getCharacterStream());
//                while ((str = br.readLine()) != null) {
//                    strOut.append(str);
//                }
//                br.close();
//            }
//        }
        model.addAttribute("store_list", storeList);
        return "member/store/storeSearch";
    }

}
package com.mindthehippo.budget.core;

import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.application.WonderfulTipService;
import com.mindthehippo.budget.application.dto.TipDTO;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implements something advanced to analyze user budget and give him amazing
 * tips to achieve his goals. Save money decreasing expenses, dealing loans or
 * investments
 *
 * @author Novaes
 */
@Component
public class WonderfulTipServiceImpl implements WonderfulTipService {

    @Autowired
    BudgetRepository budgetRepository;

    static final String tip1 = "<strong>Valuable Tip!</strong> Looks like a fair part"
            + " of your budget is used to pay loan installments. \n"
            + "Did you know that <a href=\"http://partnerpage.com\">Bank X</a> "
            + "has great interest rates ? Lowering loan installments in 10% "
            + "would allow you to reach the 'New TV' goal <b>X weeks faster</b> !";

    static final String tip2 = "<strong>Warning!</strong> You increase your expenses "
            + "eating out this week. Evaluate this cost and keep moving to buy "
            + "your 'New Bicycle' goal in <b>X weeks</b> !";

    static final String tip3 = "<strong>Amazing !</strong> Your new investment was a good return last week. "
            + "Consider to allocate X more into this investment and ";

    static List<TipDTO> tips = Arrays.asList(new TipDTO(tip1), new TipDTO(tip3), new TipDTO(tip3));

    @Override
    public List<TipDTO>  get(UUID account) {
        Budget budget = budgetRepository.get(account);
        // analyzes items and goals.. returns wonderful tips
        //Random rd = new Random();
        //return tips.get(rd.nextInt(2));
        return tips;
    }

}

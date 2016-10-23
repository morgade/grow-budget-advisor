package com.mindthehippo.budget.core;

import com.mindthehippo.budget.aggregate.budget.Budget;
import com.mindthehippo.budget.aggregate.budget.BudgetRepository;
import com.mindthehippo.budget.application.WonderfulTipService;
import com.mindthehippo.budget.application.dto.TipDTO;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This should analyze items and goals, process account events, do some data 
 * science to generate great tips for the user to achieve his goals. 
 * Save money decreasing expenses, dealing loans or investments
 *
 * @author Novaes
 */
@Component
public class WonderfulTipServiceImpl implements WonderfulTipService {

    @Autowired
    BudgetRepository budgetRepository;

    private TipDTO[] mockTips = {
        new TipDTO("<strong>Valuable Tip!</strong> Looks like a fair part"
            + " of your budget is used to pay loan installments. \n"
            + "Did you know that <a href=\"http://partnerpage.com\">Bank X</a> "
            + "has great interest rates ? Lowering loan installments in 10% "
            + "would allow you to reach the 'New TV' goal <b>X weeks faster</b> !", "warning"),
        new TipDTO("<strong>Good Job!</strong>You are spending with utilities bills less "
                + "than what was foressen in your budget ! It's a good way to saving for your goals. "
                + "If you adjust your budget to what was realized, you will reach the 'New TV' <b>X weeks faster</b>", "success"),
        new TipDTO("<strong>Taxes are inevitable ....</strong>"
                + "And your budget has been suffering with it. Did you know that investing in <a href=\"http://partnerpage.com\">X invest</a> "
                + "you can deduct taxes and save still more for your goals ? Give it a try !", "danger"),
    };

    @Override
    public List<TipDTO>  get(UUID account) {
        Budget budget = budgetRepository.get(account);
        // TODO: analyze items and goals, proccess account events, do some data science to generate great tips for the user dashboard !
        return Arrays.asList(mockTips);
    }

}

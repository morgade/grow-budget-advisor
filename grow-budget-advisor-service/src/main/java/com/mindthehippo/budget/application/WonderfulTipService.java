package com.mindthehippo.budget.application;

import com.mindthehippo.budget.application.dto.TipDTO;
import java.util.UUID;

/**
 *
 * @author Novaes
 */
public interface WonderfulTipService {

    TipDTO get(UUID accountId);

}

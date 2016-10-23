package com.mindthehippo.budget.application;

import com.mindthehippo.budget.application.dto.TipDTO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Novaes
 */
public interface WonderfulTipService {

    List<TipDTO> get(UUID accountId);
    
}

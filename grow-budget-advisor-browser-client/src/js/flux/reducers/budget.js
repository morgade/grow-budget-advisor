// 3rd party modules
import objectAssign from 'object-assign';
// project modules
import { reducer } from '../util/creators'
import * as CommonActions from '../actions/common'
import * as BudgetActions from '../actions/budget'

/**
 * Reducer state structure
 */
const initialState =  {
    authenticationFeedback: null,
    user: null,
    account: null,
    pendingFetch: true,
    categories: [],
    data: { 
      items: [ ],
      goals: [ ],
      tips: []
    }
};

/**
 * Budget Reducer handlers
 */
export default reducer(initialState, {
        
    [CommonActions.SERVICE_FAILURE]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: false
        }),
        
    [CommonActions.LOGON_REQUEST]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: true
        }),
    
    [CommonActions.FETCH_BUDGET_REQUEST]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: true
        }),
        
    [CommonActions.FETCH_CATEGORIES_REQUEST]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: true
        }),
        
    [CommonActions.ADD_ITEM_REQUEST]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: true
        }),
    
    [CommonActions.LOGON_SUCCESS]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: false,
            authenticationFeedback: action.feedback,
            account: action.feedback.authenticated ? action.feedback.authenticated.account : null,
            user: action.feedback.authenticated ? action.feedback.authenticated.user : null
        }),
    
    [BudgetActions.FETCH_CATEGORIES_RESPONSE]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: false,
            categories: action.categories
        }),
    
    [BudgetActions.FETCH_BUDGET_RESPONSE]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: false,
            data: action.budget
        })
        
});
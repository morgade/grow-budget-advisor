import objectAssign from 'object-assign';

import { reducer } from '../util/creators'
import * as CommonActions from '../actions/common'

/**
 * Reducer state structure
 */
const initialState =  {
    authenticationFeedback: null,
    account: null,
    pendingFetch: true
};

/**
 * Reducer handlers
 */
export default reducer(initialState, {
        
    [CommonActions.SERVICE_FAILURE]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: false
        }),
        
    [CommonActions.LOGON_SUCCESS]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: true
        }),
    
    [CommonActions.LOGON_SUCCESS]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: false,
            authenticationFeedback: action.feedback,
            account: action.feedback.account ? action.feedback.account : null
        })
    
});
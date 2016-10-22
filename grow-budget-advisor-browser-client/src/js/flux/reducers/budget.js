import objectAssign from 'object-assign';

import { reducer } from '../util/creators'
import * as CommonActions from '../actions/common'

/**
 * Reducer state structure
 */
const initialState =  {
    authenticationFeedback: null,
    user: null,
    account: null,
    pendingFetch: true,
    data: { 
//    items: [ { id:'1', category: 'PAYCHECK', amount: 100, label: 'Weekly payment' }, { id:'2', category: 'PAYCHECK', amount: 100, label: 'Weekly payment' } ],
//    goals: [ { id:'1', text: 'TV', amount: 300}, { id:'2', text: 'Bike', amount: 100 } ]
      items: [ ],
      goals: [ { id:'1', text: 'TV', amount: 300}, { id:'2', text: 'Bike', amount: 100 } ]
    }
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
            account: action.feedback.authenticated ? action.feedback.authenticated.account : null,
            user: action.feedback.authenticated ? action.feedback.authenticated.user : null
        })
        
});
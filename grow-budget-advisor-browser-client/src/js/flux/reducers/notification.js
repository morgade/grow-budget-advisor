import objectAssign from 'object-assign';

import { reducer } from '../util/creators'
import * as CommonActions from '../actions/common'
import * as NotificationActions from '../actions/notification'
import * as BudgetActions from '../actions/budget'

/**
 * Comments reducer state structure
 */
const initialState =  null;

/**
 * Notification reducer
 */
export default reducer(initialState, {
    
    [CommonActions.SERVICE_FAILURE]: (state, action) => 
        objectAssign({}, state, {
            message: action.error.message,
            level: 'error'
        }),
    
    [NotificationActions.NOTIFY_ERROR]: (state, action) => 
        objectAssign({}, state, {
            message: action.message,
            level: 'error'
        }),
    
    [BudgetActions.ADD_ITEM_RESPONSE]: (state, action) => 
        objectAssign({}, state, {
            message: 'Budget item created',
            level: 'success'
        }),
    
    [BudgetActions.ADD_GOAL_RESPONSE]: (state, action) => 
        objectAssign({}, state, {
            message: 'Goal created',
            level: 'success'
        })
    
});
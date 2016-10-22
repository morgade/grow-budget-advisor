import objectAssign from 'object-assign';

import { reducer } from '../util/creators'
import * as CommonActions from '../actions/common'
import * as NotificationActions from '../actions/notification'


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
        })
    
});
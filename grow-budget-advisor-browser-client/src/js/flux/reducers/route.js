import objectAssign from 'object-assign';

import { reducer } from '../util/creators'
import * as RouteActions from '../actions/route'


/**
 * Comments reducer state structure
 */
const initialState = {
    current: '/'
};

/**
 * Notification reducer
 */
export default reducer(initialState, {
    
    [RouteActions.ROUTE_CHANGE]: (state, action) => 
        objectAssign({}, state, {
            current: action.route
        })
    
});
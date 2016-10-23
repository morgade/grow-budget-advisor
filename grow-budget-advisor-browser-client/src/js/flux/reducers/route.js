// 3rd party modules
import objectAssign from 'object-assign';
// project modules
import { reducer } from '../util/creators'
import * as RouteActions from '../actions/route'


/**
 * Route reducer state structure
 */
const initialState = {
    current: '/'
};

/**
 * Route reducer
 */
export default reducer(initialState, {
    
    [RouteActions.ROUTE_CHANGE]: (state, action) => 
        objectAssign({}, state, {
            current: action.route
        })
    
});
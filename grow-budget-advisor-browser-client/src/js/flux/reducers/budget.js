import objectAssign from 'object-assign';

import { reducer } from '../util/creators'
import * as CommonActions from '../actions/common'

/**
 * Reducer state structure
 */
const initialState =  {
    pendingFetch: true
};

/**
 * Reducer handlers
 */
export default reducer(initialState, {
        
    [CommonActions.SERVICE_FAILURE]: (state, action) =>
        objectAssign({}, state, { 
            pendingFetch: false
        })
    
});
import thunkMiddleware from 'redux-thunk'
import createLogger from 'redux-logger'
import { createStore, combineReducers, applyMiddleware } from 'redux'

import budget from './reducers/budget';
import notification from './reducers/notification';


const mainReducer = combineReducers({budget, notification});

export default createStore(mainReducer,
                            applyMiddleware(
                                thunkMiddleware,
                                createLogger()
                            )
                );

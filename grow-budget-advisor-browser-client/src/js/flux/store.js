// 3rd party modules
import thunkMiddleware from 'redux-thunk'
import createLogger from 'redux-logger'
import { createStore, combineReducers, applyMiddleware } from 'redux'
// project modules
import budget from './reducers/budget';
import notification from './reducers/notification';
import route from './reducers/route';


/**
 * Combiner reducer and flux store definition
 */
const mainReducer = combineReducers({budget, notification, route});

export default createStore(mainReducer,
                            applyMiddleware(
                                thunkMiddleware,
                                createLogger()
                            )
                );

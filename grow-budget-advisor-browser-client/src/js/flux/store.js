import thunkMiddleware from 'redux-thunk'
import createLogger from 'redux-logger'
import { createStore, combineReducers, applyMiddleware } from 'redux'

import budget from './reducers/budget';
import notification from './reducers/notification';
import route from './reducers/route';


const mainReducer = combineReducers({budget, notification, route});

export default createStore(mainReducer,
                            applyMiddleware(
                                thunkMiddleware,
                                createLogger()
                            )
                );

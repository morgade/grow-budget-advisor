import rest from '../util/rest'
import * as CommonActions from './common'
import {sync, async, route} from '../util/creators'

// ACTION TYPES
export const FETCH_BUDGET_REQUEST = 'FETCH_BUDGET_REQUEST';
export const FETCH_BUDGET_RESPONSE = 'FETCH_BUDGET_RESPONSE';


// SYNC ACTIONS
export const fetchBudgetRequest = sync(FETCH_BUDGET_REQUEST, 'account');
export const fetchBudgetResponse = sync(FETCH_BUDGET_RESPONSE, 'budget');

//ASYNC ACTIONS
export const fetchBudget = async(args => rest.get(`/budget/${args[0]}`), fetchBudgetRequest, fetchBudgetRequest, CommonActions.serviceFailure); 
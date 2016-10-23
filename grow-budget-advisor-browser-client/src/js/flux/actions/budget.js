import rest from '../util/rest'
import * as CommonActions from './common'
import {sync, async, route} from '../util/creators'

// ACTION TYPES
export const FETCH_BUDGET_REQUEST = 'FETCH_BUDGET_REQUEST';
export const FETCH_BUDGET_RESPONSE = 'FETCH_BUDGET_RESPONSE';
export const FETCH_CATEGORIES_REQUEST = 'FETCH_CATEGORIES_REQUEST';
export const FETCH_CATEGORIES_RESPONSE = 'FETCH_CATEGORIES_RESPONSE';
export const ADD_ITEM_REQUEST = 'ADD_ITEM_REQUEST';
export const ADD_ITEM_RESPONSE = 'ADD_ITEM_RESPONSE';


// SYNC ACTIONS
export const fetchBudgetRequest = sync(FETCH_BUDGET_REQUEST, 'account');
export const fetchBudgetResponse = sync(FETCH_BUDGET_RESPONSE, 'budget');
export const addItemRequest = sync(ADD_ITEM_REQUEST, 'item');
export const addItemResponse = sync(ADD_ITEM_RESPONSE);
export const fetchCategoriesRequest = sync(FETCH_CATEGORIES_REQUEST);
export const fetchCategoriesResponse = sync(FETCH_CATEGORIES_RESPONSE, 'categories');

//ASYNC ACTIONS
export const fetchBudget = async(args => rest.get(`/budget/${args[0]}`), fetchBudgetRequest, fetchBudgetResponse, CommonActions.serviceFailure); 
export const fetchCategories = async(args => rest.get('/category'), fetchCategoriesRequest, fetchCategoriesResponse, CommonActions.serviceFailure); 
export const addBudgetItem = async(args => rest.post(`/budget/${args[0]}/item`, args[1]), addItemRequest, addItemResponse, CommonActions.serviceFailure); 

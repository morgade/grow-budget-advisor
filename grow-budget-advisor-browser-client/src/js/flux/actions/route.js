/**
 * These are FLUX actions used to control the routing system
 */

import { hashHistory } from 'react-router'

import { sync } from '../util/creators'

// ACTION TYPES
export const ROUTE_CHANGE = 'ROUTE_CHANGE';

// SYNCHRONOUS ACTION CREATORS
const _routeChange = sync(ROUTE_CHANGE, 'route');

// SPECIALIZED ACTION HANDLERS
export const routeChange = function(route) {
    return (dispatch, getState) => {
        hashHistory.push(route);
        return dispatch(_routeChange(route));
   };
};
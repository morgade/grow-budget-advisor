/**
 *  These are some misc FLUX action creators
 */

import { hashHistory } from 'react-router'

import { sync, async } from '../util/creators'
import rest from '../util/rest'

// ACTION TYPES
export const LOGON_REQUEST = 'LOGON_REQUEST';
export const LOGON_SUCCESS = 'LOGON_SUCCESS';
export const SERVICE_FAILURE = 'SERVICE_FAILURE';

// SYNCHRONOUS ACTION CREATORS
export const serviceFailure = sync(SERVICE_FAILURE, 'error');


export const logonRequest = sync(LOGON_REQUEST, 'credentials');
export const logonResponse = sync(LOGON_SUCCESS, 'feedback');

export const logon = async(args => rest.postForm('/login', args[0]), logonRequest, logonResponse, serviceFailure); 
/**
 *  These are FLUX actions used by the notification syste
 */

import { hashHistory } from 'react-router'

import { sync } from '../util/creators'

// ACTION TYPES
export const NOTIFY_ERROR = 'NOTIFY_ERROR';

// SYNCHRONOUS ACTION CREATORS
export const notifyError = sync(NOTIFY_ERROR, 'message');
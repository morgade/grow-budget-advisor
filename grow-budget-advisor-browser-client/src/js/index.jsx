import Index from 'file?name=[name].[ext]!../index.html';
import BudgetLess from '../less/budget.less';
import BootstrapCSS from 'bootstrap/dist/css/bootstrap.min.css';

import React from 'react'
import ReactDom from 'react-dom'
import { Router, Route, IndexRedirect, Redirect, hashHistory } from 'react-router'
import { Provider } from 'react-redux'

import App from './react/app.jsx';
import Home from './react/home.jsx';
import SignIn from './react/sign-in/sign-in.jsx';
import Budget from './react/budget/Budget.jsx';
import store from './flux/store'

require('es6-promise').polyfill();

ReactDom.render(
        <Provider store={store}>
            <Router history={hashHistory}>
                <Route path="/" component={App}>
                    <IndexRedirect to="home" />
                    <Route path="home" component={Home} />
                    <Route path="sign-in" component={SignIn} />
                    <Route path="budget" component={Budget} />
                    <Redirect from="*" to="home" />
                </Route>
            </Router> 
        </Provider>
, document.getElementById('app'));
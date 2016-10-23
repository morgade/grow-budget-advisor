// 3rd party modules
import React from 'react'
import ReactDom from 'react-dom'
import { Router, Route, IndexRedirect, Redirect, hashHistory } from 'react-router'
import { Provider } from 'react-redux'

// less, css and html resources
import Index from 'file?name=[name].[ext]!../index.html';
import BudgetLess from '../less/budget.less';
import BootstrapCSS from 'bootstrap/dist/css/bootstrap.min.css';

// project modules
import App from './react/app.jsx';
import Home from './react/home.jsx';
import SignIn from './react/sign-in/sign-in.jsx';
import Budget from './react/budget/budget.jsx';
import Goals from './react/goals/goals.jsx';
import Dashboard from './react/dashboard/dashboard.jsx';
import store from './flux/store'

require('es6-promise').polyfill();

/**
 *  This is our index js, used to deinfe depedencies to html/css resources
 *  used by webpack
 *  
 *  Routing configuration is also here
 */
ReactDom.render(
        <Provider store={store}>
            <Router history={hashHistory}>
                <Route path="/" component={App}>
                    <IndexRedirect to="home" />
                    <Route path="home" component={Home} />
                    <Route path="sign-in" component={SignIn} />
                    <Route path="budget" component={Budget} />
                    <Route path="goals" component={Goals} />
                    <Route path="dashboard" component={Dashboard} />
                    <Redirect from="*" to="home" />
                </Route>
            </Router> 
        </Provider>
, document.getElementById('app'));
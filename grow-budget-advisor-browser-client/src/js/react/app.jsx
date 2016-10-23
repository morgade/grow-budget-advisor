// 3rd party modules
import React from 'react';
import {connect} from 'react-redux';

// project modules
import BudgetNavBar from './navbar/budget-nav-bar.jsx';
import Notification from './notification/notification.jsx';

import * as RouteActions from '../flux/actions/route';

/**
 * This is our main container class. I hosts a navbar container and
 * props defined children
 * @type App
 */
class App extends React.Component {
    
    /**
     * When componentDidMount, we ask to resoutes to the '/'  path if there 
     * are no information about the signed user
     */
    componentDidMount() {
        if (!this.props.budget.user ) {
            this.props.dispatch(RouteActions.routeChange('/'));
        }
    }
    
    /**
     * Renders this compoen
     */
    render() {
        return (
            <div>
                <BudgetNavBar />
                <div className="container">
                    {this.props.children}
                </div>
                <Notification />
            </div>
        );
    }
};

export default connect( store => ({budget: store.budget }) )(App);
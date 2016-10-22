import React from 'react';
import {connect} from 'react-redux';

import BudgetNavBar from './navbar/budget-nav-bar.jsx';
import Notification from './notification/notification.jsx';

import * as RouteActions from '../flux/actions/route';

class App extends React.Component {
    componentDidMount() {
        if (!this.props.budget.user ) {
            this.props.dispatch(RouteActions.routeChange('/'));
        }
    }
    
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
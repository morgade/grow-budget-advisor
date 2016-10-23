// 3rd party modules
import React from 'react';
import { connect, dispatch } from 'react-redux';
import Button from 'react-bootstrap/lib/Button';
import Jumbotron from 'react-bootstrap/lib/Jumbotron';

// project modules
import * as RouteActions from '../flux/actions/route';

/**
 * A welcome jumbotron component linked to the sign-in route
 */
class Home extends React.Component {
    /**
     * Dispatches action to change route to sign-in
     */
    signin() {
        this.props.dispatch(RouteActions.routeChange('/sign-in'));
    }
    
    render() {
        return (
             <Jumbotron>
                <h1>Grow Budget Advisor</h1>
                <p>This the Budget Advisor interface by Mind the Hippo. Our project is focused on defining the architecture and the idea 
                of a financial advisor that uses integrated bank account transaction events to posts charts and tips in a dashboard (Charts'n Tips) helping the user to
                achieve its goals. </p>
                <p>Sign-ing with the user: 'dennis' and password: 'grow' to load some pre-defined data and check it out.</p>
                <p><Button bsStyle="primary"  onClick={this.signin.bind(this)}>Sign-in</Button></p>
              </Jumbotron>
        );
    }
};

export default connect()(Home);
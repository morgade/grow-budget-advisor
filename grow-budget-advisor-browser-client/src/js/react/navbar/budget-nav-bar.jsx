// 3rd party modules
import React from 'react';
import Nav from 'react-bootstrap/lib/Nav';
import NavItem from 'react-bootstrap/lib/NavItem';
import NavDropdown from 'react-bootstrap/lib/NavDropdown';
import Navbar from 'react-bootstrap/lib/Navbar';
import MenuItem from 'react-bootstrap/lib/MenuItem';
import Button from 'react-bootstrap/lib/Button';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import { connect, dispatch } from 'react-redux'

// project modules
import * as RouteActions from '../../flux/actions/route';

/**
 * The app navbar
 */
class BudgetNavBar extends React.Component {
    /**
     * Disptches a routing action
     * @param {string} route
     */
    routeChange(route) {
        this.props.dispatch(RouteActions.routeChange(route));
    }

    /**
     * React render method
     */
    render() {
        return (
            <Navbar fixedTop fluid>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a className="navbar-brand" href="#/">Budget Advisor</a>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                        {this.props.budget.user ? 
                            <Nav>
                                <NavItem onClick={()=>this.routeChange('/budget')} className={this.props.route.current==='/budget'?'active':null}>
                                    My Budget
                                </NavItem> 
                                <NavItem onClick={()=>this.routeChange('/goals')} className={this.props.route.current==='/goals'?'active':null}>
                                    My Goals
                                </NavItem> 
                                <NavItem onClick={()=>this.routeChange('/dashboard')} className={this.props.route.current==='/dashboard'?'active':null}>
                                    Charts'n Tips
                                </NavItem> 
                            </Nav>
                            : 
                            null
                        }
                    
                        {this.props.budget.user ?
                            <Nav pullRight>
                                <NavItem>Hello, {this.props.budget.user} !</NavItem>
                            </Nav>
                            :
                            <Navbar.Form pullRight>
                                <FormGroup>
                                    <Button bsStyle="primary" onClick={() => this.routeChange('/sign-in')}>SET YOUR BUDGET AND GOALS, START SAVING !</Button>
                                </FormGroup>
                            </Navbar.Form>
                        }
                    
                </Navbar.Collapse>
            </Navbar>
        );
    }

};

export default connect( state => ({ budget: state.budget, route: state.route }))(BudgetNavBar);
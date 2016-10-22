import React from 'react';
import Nav from 'react-bootstrap/lib/Nav';
import NavItem from 'react-bootstrap/lib/NavItem';
import NavDropdown from 'react-bootstrap/lib/NavDropdown';
import Navbar from 'react-bootstrap/lib/Navbar';
import MenuItem from 'react-bootstrap/lib/MenuItem';
import { connect, dispatch } from 'react-redux'

import * as RouteActions from '../../flux/actions/route';

class TitleBar extends React.Component {

    routeChange(route) {
        this.props.dispatch(RouteActions.routeChange(route));
    }

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
                    <Nav pullRight>
                        <NavItem eventKey={1} onClick={this.routeChange}>Link</NavItem>
                        <NavItem eventKey={2} href="#">Link</NavItem>
                        <NavItem eventKey={2} onClick={() => this.routeChange('/sign-in')}>REACH YOUR GOALS</NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        );
    }

}

export default connect()(TitleBar);
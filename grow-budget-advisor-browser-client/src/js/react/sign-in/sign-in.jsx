import React from 'react';
import {connect} from 'react-redux';
import cookie from 'cookie';

import Form from 'react-bootstrap/lib/Form';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import FormControl from 'react-bootstrap/lib/FormControl';
import Button from 'react-bootstrap/lib/Button';
import Row from 'react-bootstrap/lib/Row';
import Col from 'react-bootstrap/lib/Col';
import HelpBlock from 'react-bootstrap/lib/HelpBlock';

import * as CommonActions from '../../flux/actions/common';
import * as RouteActions from '../../flux/actions/route';
import * as NotificationActions from '../../flux/actions/notification';

class SignInForm extends React.Component {

    constructor(props) {
        super(props);
        this.login = this.login.bind(this);
        this.onChange = this.onChange.bind(this);
    }
    
    componentDidMount() {
        this.state = {
            user: '',
            password: ''
        };
    }
    
    componentWillReceiveProps(props) {
        console.log(props.authenticationFeedback);
        if (props.authenticationFeedback && props.authenticationFeedback.failure) {
            this.props.dispatch(NotificationActions.notifyError(props.authenticationFeedback.failure));
        } else if (props.authenticationFeedback && props.authenticationFeedback.authenticated) {
            this.props.dispatch(RouteActions.routeChange('/budget'));
        }
    }
    
    login(evt) {
        this.props.dispatch( CommonActions.logon({
                username: this.state.user, 
                password: this.state.password,
                _csrf: cookie.parse(document.cookie)['XSRF-TOKEN']
        }));
        evt.preventDefault();
    }
    
    onChange(evt, field) {
        this.setState({ [field]: evt.target.value });
    }
    
    render() {
        return (
                <Row>
                    <Col lg={4} lgOffset={4}>
                        <Form onSubmit={this.login}>
                            <FormGroup controlId="email">
                                <ControlLabel>e-Mail</ControlLabel>
                                <FormControl type="text" placeholder="Linked email account" onChange={(evt) => this.onChange(evt, 'user') } />
                                <HelpBlock>This is a mock</HelpBlock>
                            </FormGroup>
                            <FormGroup controlId="password">
                                <ControlLabel>Password</ControlLabel>
                                <FormControl type="password" placeholder="" onChange={(evt) => this.onChange(evt, 'password') }/>
                            </FormGroup>
                            <FormGroup controlId="actions" >
                                <Button type="submit" bsStyle="primary" className="pull-right"> GET STARTED</Button>
                            </FormGroup>
                        </Form>
                    </Col>
                </Row>
        );
    }
};

export default connect( state => ({ 
        authenticationFeedback: state.budget.authenticationFeedback
    }))(SignInForm);
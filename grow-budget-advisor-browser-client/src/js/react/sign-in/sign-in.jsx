// 3rd party modules
import React from 'react';
import {connect} from 'react-redux';
import Form from 'react-bootstrap/lib/Form';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import FormControl from 'react-bootstrap/lib/FormControl';
import Button from 'react-bootstrap/lib/Button';
import Row from 'react-bootstrap/lib/Row';
import Col from 'react-bootstrap/lib/Col';
import HelpBlock from 'react-bootstrap/lib/HelpBlock';

// project modules
import * as CommonActions from '../../flux/actions/common';
import * as RouteActions from '../../flux/actions/route';
import * as BudgetActions from '../../flux/actions/budget';
import * as NotificationActions from '../../flux/actions/notification';

/**
 * A sign-in component
 */
class SignInForm extends React.Component {
    /**
     * Function binding initialization
     * @param {object} props
     */
    constructor(props) {
        super(props);
        this.login = this.login.bind(this);
        this.onChange = this.onChange.bind(this);
        this.state = {
            user: '',
            password: ''
        };
    }
    
    /**
     * Dispatchs notifying and reroute action when authentication feedback
     * becomes available
     * @param {object} newProps
     */
    componentWillReceiveProps(newProps) {
        if (newProps.budget.authenticationFeedback && newProps.budget.authenticationFeedback.failure) {
            this.props.dispatch(NotificationActions.notifyError(newProps.budget.authenticationFeedback.failure));
        } else if (newProps.budget.authenticationFeedback && newProps.budget.authenticationFeedback.authenticated) {
            this.props.dispatch(BudgetActions.fetchBudget(newProps.budget.authenticationFeedback.authenticated.account));
            this.props.dispatch(BudgetActions.fetchCategories());
            this.props.dispatch(RouteActions.routeChange('/budget'));
        }
    }
    
    /**
     * Dispatch a logon action on form submission
     * @param {Event} evt
     */
    login(evt) {
        this.props.dispatch( CommonActions.logon({
                username: this.state.user, 
                password: this.state.password
        }));
        evt.preventDefault();
    }
    
    /**
     * Multipurpose change event
     * @param {Event} evt
     * @param {string} field
     */
    onChange(evt, field) {
        this.setState({ [field]: evt.target.value });
    }
    
    /**
     * React render method
     */
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

export default connect( state => ({ budget: state.budget }))(SignInForm);

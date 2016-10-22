import React from 'react';
import { connect, dispatch } from 'react-redux'

import Form from 'react-bootstrap/lib/Form';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import FormControl from 'react-bootstrap/lib/FormControl';
import Button from 'react-bootstrap/lib/Button';

class ItemForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            amount: '0',
            text: ''
        };
    }
    onChange(evt, field) {
        this.setState({ [field]: evt.target.value });
    }

    render() {
        return (
            <Form onSubmit={this.login}>
                <FormGroup controlId="text">
                    <ControlLabel>Label</ControlLabel>
                    <FormControl type="text" placeholder="Describe your Goal" onChange={(evt) => this.onChange(evt, 'text') } />
                </FormGroup>
                <FormGroup controlId="amount">
                    <ControlLabel>Amount ($)</ControlLabel>
                    <FormControl type="text" placeholder="How much it costs ?" onChange={(evt) => this.onChange(evt, 'amount') }/>
                </FormGroup>
            </Form>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(ItemForm);
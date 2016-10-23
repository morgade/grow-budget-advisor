// 3rd party modules
import React from 'react';
import { connect, dispatch } from 'react-redux'
import Form from 'react-bootstrap/lib/Form';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import FormControl from 'react-bootstrap/lib/FormControl';
import Button from 'react-bootstrap/lib/Button';
import Modal from 'react-bootstrap/lib/Modal';
// project modules
import * as BudgetActions from '../../flux/actions/budget'

/**
 *  A modal form to generate goals
 */
class GoalForm extends React.Component {
    /**
     * Define initial component state
     * @param {object} props
     */
    constructor(props) {
        super(props);
        this.state = {
            show: false,
            amount: '0',
            text: ''
        };
    }
    
    /**
     * Change state to close the modal
     */
    close() {
        this.setState({ show: false });
    }

    /**
     * Change state to open the modal
     */
    open() {
      this.setState({ show: true });
    }
    
    /**
     * Multi purpose change event handler
     * @param {Event} evt
     * @param {string} field
     */
    onChange(evt, field) {
        this.setState({ [field]: evt.target.value });
    }

    /**
     * Dispatches a goal creation request and wait to close modal
     * TODO: Validate form data
     */
    confirm() {
      this.props.dispatch(BudgetActions.addGoalItem(
                this.props.budget.account,
                {
                    amount: this.state.amount,
                    text: this.state.text
                }
            )
        ).then( () => { 
            this.close();
            this.props.dispatch(BudgetActions.fetchBudget(this.props.budget.account));
        });
    }
    
    /**
     * React render method
     */
    render() {
        return (
            <div>
                <Button bsStyle="primary" className="pull-right" onClick={(evt)=>this.open()}>ADD GOAL</Button>
                <Modal show={this.state.show} onHide={this.close}>
                <Modal.Header>
                    <Modal.Title>Add Goal</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                        <Form onSubmit={(evt) => this.confirm()}>
                            <FormGroup controlId="text">
                                <ControlLabel>Describe your Goal</ControlLabel>
                                <FormControl type="text" placeholder="Goal description" onChange={(evt) => this.onChange(evt, 'text') } />
                            </FormGroup>
                            <FormGroup controlId="amount">
                                <ControlLabel>Amount ($)</ControlLabel>
                                <FormControl type="text" placeholder="How much is your goal" onChange={(evt) => this.onChange(evt, 'amount') }/>
                            </FormGroup>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                              <Button bsStyle="danger" onClick={this.close.bind(this)}>Cancel</Button>
                              <Button bsStyle="primary" onClick={(evt) => this.confirm()}>Create</Button>
                    </Modal.Footer>
                </Modal>
            </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(GoalForm);

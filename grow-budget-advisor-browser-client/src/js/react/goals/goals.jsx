import React from 'react';
import { connect, dispatch } from 'react-redux'

import Button from 'react-bootstrap/lib/Button';
import ListGroup from 'react-bootstrap/lib/ListGroup';
import Modal from 'react-bootstrap/lib/Modal';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Item from './item.jsx';
import ItemForm from './item-form.jsx';

class Goals extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            showItemModal: false
        };
    }
    
    close() {
        this.setState({ showItemModal: false });
    }

    open() {
      this.setState({ showItemModal: true });
    }
    
    render() {
        const items = this.props.budget.data.goals.map( (goal) => 
                <Item key={goal.id} item={goal} /> 
            );
        
        return (
                <div>
                    <PageHeader>
                        <Button bsStyle="primary" className="pull-right" onClick={(evt)=>this.open()}>ADD ITEM</Button>
                        My Goals
                    </PageHeader>
                    
                    <ListGroup>
                        {items}
                    </ListGroup>
                    
                    <Modal show={this.state.showItemModal} onHide={this.close}>
                        <Modal.Header>
                          <Modal.Title>Add a New Goal</Modal.Title>
                        </Modal.Header>
                    <Modal.Body>
                      <ItemForm />
                    </Modal.Body>
                    <Modal.Footer>
                      <Button onClick={(evt)=>this.close()}>Close</Button>
                    </Modal.Footer>
                  </Modal>
                </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Goals);
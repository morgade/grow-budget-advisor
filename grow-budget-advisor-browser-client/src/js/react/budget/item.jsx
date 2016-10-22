import React from 'react';
import { connect, dispatch } from 'react-redux'

import ListGroupItem from 'react-bootstrap/lib/ListGroupItem';

class Budget extends React.Component {

    render() {
        return (
            <ListGroupItem header={this.props.item.text}>
                {this.props.item.category}
                <div className="pull-right">
                    ${this.props.item.amount}
                </div>
            </ListGroupItem>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Budget);
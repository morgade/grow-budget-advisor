import React from 'react';
import { connect, dispatch } from 'react-redux'

import ListGroupItem from 'react-bootstrap/lib/ListGroupItem';

class Budget extends React.Component {

    render() {
        return (
            <ListGroupItem>
                {this.props.item.text}
                <p className="pull-right">
                    ${this.props.item.amount}
                </p>
            </ListGroupItem>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Budget);
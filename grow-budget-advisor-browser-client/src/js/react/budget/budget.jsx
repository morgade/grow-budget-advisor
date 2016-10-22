import React from 'react';
import { connect, dispatch } from 'react-redux'
import Row from 'react-bootstrap/lib/Row';
import Col from 'react-bootstrap/lib/Col';
import PageHeader from 'react-bootstrap/lib/PageHeader';

class Budget extends React.Component {

    render() {
        return (
                <div>
                    <PageHeader>My planned budget</PageHeader>
                    <Col md={12}>
                        My planned budget
                    </Col>
                </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Budget);
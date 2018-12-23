import React,{Component} from 'react';
import { Button, FormGroup, Col} from 'react-bootstrap'

export default class ButtonSuccess extends Component {
    render(){
        return(
            <>
                <FormGroup>
                    <Col smOffset={2} sm={10}>
                        <Button className="btn-default" type="submit">{this.props.isCreate?'Создать':'Редактировать'}</Button>
                    </Col>
                </FormGroup>
            </>
        );
    }
}
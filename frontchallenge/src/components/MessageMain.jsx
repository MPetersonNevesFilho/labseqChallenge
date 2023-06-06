/* eslint-disable react/prop-types */
import '../styles/MessageMain.css'
import trash from '../assets/imgs/trash.svg'
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { LabseqDelete } from '../services/RequestApi';

export default function MessageMain(props) {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const nValue = props.n;
    const numbers = props.numbers;

    const handleDeleteClick = () => {
        LabseqDelete(nValue)
        .then(() => {
            props.deleteFunc(nValue);
            setShow(false);
        });
    }

    return (
        <>
            <div className='messageMain'>
                <div className='messageTitle'>
                        <p>N = {nValue}</p>

                </div>
                <div className='messageContent'>
                    <p className='messageContentP'>{numbers}</p>
                </div>
                <div className='messageTime'>
                    <a onClick={handleShow}>
                        <img src={trash} alt='trashIcon' className='messageTrashIcon'/>
                    </a>
                </div>
            </div>


            <Modal show={show} onHide={handleClose} centered>
        <Modal.Header closeButton>
          <Modal.Title>Delete number</Modal.Title>
        </Modal.Header>
        <Modal.Body>Are you sure you want to delete the number {nValue}?</Modal.Body>
        <Modal.Footer>
          <Button variant="danger" onClick={handleDeleteClick}>
            Delete
          </Button>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
        </>
    )
}
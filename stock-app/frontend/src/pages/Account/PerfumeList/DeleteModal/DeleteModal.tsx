import React, { FC, ReactElement } from "react";
import { Col, Modal, Row, Typography } from "antd";

import { ProductResponse } from "../../../../types/types";
import "./DeleteModal.css";

type PropsType = {
    visible: boolean;
    deleteProductHandler: () => void;
    handleCancel: () => void;
    perfumeInfo?: ProductResponse;
};

const DeleteModal: FC<PropsType> = ({ visible, deleteProductHandler, handleCancel, perfumeInfo }): ReactElement => {
    return (
        <Modal title="Delete perfume" visible={visible} onOk={deleteProductHandler} onCancel={handleCancel}>
            <Row>
                <Col span={12} className={"delete-modal-perfume-image-wrapper"}>
                    <img
                        className={"delete-modal-perfume-image"}
                        alt={perfumeInfo?.perfumeTitle}
                        src={perfumeInfo?.filename}
                    />
                </Col>
                <Col span={12}>
                    <Typography.Text>Are you sure too delete?</Typography.Text>
                    <Typography.Title level={5}>{perfumeInfo?.perfumer}</Typography.Title>
                    <Typography.Title level={5}>{perfumeInfo?.perfumeTitle}</Typography.Title>
                </Col>
            </Row>
        </Modal>
    );
};

export default DeleteModal;
